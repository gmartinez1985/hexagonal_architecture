package com.gfmartinez.hexagonalarchitecture.domain.model.entity;

import com.gfmartinez.hexagonalarchitecture.domain.entity.AggregateRoot;
import com.gfmartinez.hexagonalarchitecture.domain.model.exception.IncidenceDomainException;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.AttachmentFileName;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.AttachmentFormat;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.AttachmentId;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.AttachmentSize;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.AttachmentUri;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.ClientId;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.CreationDate;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.Duration;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.FinalizationDate;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.IncidenceDescription;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.IncidenceHeader;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.IncidenceId;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.IncidenceSeverity;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.IncidenceStatus;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.RepairerId;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.ReportId;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.ReporterId;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.ReviewId;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.ReviewReason;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.ReviewerId;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.Version;
import java.util.UUID;

public class Incidence extends AggregateRoot<IncidenceId> {

  private Attachment attachment;
  private final ClientId clientId;
  private final CreationDate creationDate;
  private IncidenceDescription description;
  private Duration duration;
  private FinalizationDate finalizationDate;
  private IncidenceHeader header;
  private RepairerId repairerId;
  private ReportId reportId;
  private final ReporterId reporterId;
  private Review review;
  private final IncidenceSeverity severity;
  private IncidenceStatus status;
  private Version version;

  private Incidence(IncidenceHeader header, IncidenceDescription description, ClientId clientId, IncidenceSeverity severity, ReporterId reporterId) {
    super.setId(new IncidenceId(UUID.randomUUID()));
    this.clientId = clientId;
    this.creationDate = new CreationDate();
    this.description = description;
    this.header = header;
    this.reporterId = reporterId;
    this.severity = severity;
    this.status = IncidenceStatus.IDDLE;
    this.version = new Version();
  }

  public static Incidence newIncidence(IncidenceHeader header, IncidenceDescription description, ClientId clientId, IncidenceSeverity severity,
      ReporterId reporterId) {
    return new Incidence(
        header,
        description,
        clientId,
        severity,
        reporterId
    );
  }

  public IncidenceDescription getDescription() {
    return description;
  }

  public IncidenceHeader getHeader() {
    return header;
  }

  public UUID getReportedId() {
    return reporterId.getValue();
  }

  public UUID getClientId() {
    return clientId.getValue();
  }

  public IncidenceSeverity getSeverity() {
    return severity;
  }

  public static Incidence newIncidenceWithAttachment(IncidenceHeader header, IncidenceDescription description, ClientId clientId,
      IncidenceSeverity severity, ReporterId reporterId, AttachmentId attachmentId, AttachmentFileName fileName, AttachmentFormat format,
      AttachmentSize size, AttachmentUri uri) {
    Incidence incidence = newIncidence(header, description, clientId, severity, reporterId);
    incidence.attachment = Attachment.newAttachment(attachmentId, fileName, format, incidence.id, size, uri);

    return incidence;
  }

  public CreationDate getAttachmentCreationDate() {
    checkAttachment();
    return attachment.getCreationDate();
  }

  public AttachmentFileName getAttachmentFileName() {
    checkAttachment();
    return attachment.getFileName();
  }

  public AttachmentFormat getAttachmentFormat() {
    checkAttachment();
    return attachment.getFormat();
  }
  public AttachmentSize getAttachmentSize() {
    checkAttachment();
    return attachment.getSize();
  }

  public AttachmentUri getAttachmentUri() {
    return attachment.getUri();
  }

  private void checkAttachment() {
    if(attachment == null) {
      throw new IncidenceDomainException("The incidence has no attachment.");
    }
  }

  public void approve() {
    if(this.status != IncidenceStatus.ONGOING) {
      throw new IncidenceDomainException(
          String.format("Transition to approved state is not valid from %s state", this.status)
      );
    }
    this.status = IncidenceStatus.APPROVED;
  }

  public void assign(RepairerId repairerId) {
    this.repairerId = repairerId;
    // TODO: ¿No habrá que asignarle al reparier el ID de esta Incidence?
  }

  public void cancel() {
    if(isNotCancellable()) {
      throw new IncidenceDomainException(
          String.format("Transition to cancelled state is not valid from %s state", this.status)
      );
    }
    this.status = IncidenceStatus.CANCELLED;
  }

  public void finish(Duration spentTime, FinalizationDate finalizationDate) {
    if(this.creationDate.isAfter(finalizationDate)) {
      throw new IncidenceDomainException("Finalization date can't be before initialization date");
    }
    this.duration = spentTime;
    this.finalizationDate = finalizationDate;
  }

  public void markAsIncomplete(ReviewId reviewId, ReviewReason reason, ReviewerId reviewerId) {
    if(this.status != IncidenceStatus.ONGOING) {
      throw new IncidenceDomainException(
          String.format("Transition to incompleted state is not valid from %s state", this.status)
      );
    }
    this.status = IncidenceStatus.INCOMPLETED;
    this.review = Review.newReview(reviewId, reason, reviewerId);
  }

  public void reject(ReviewId reviewId, ReviewReason reason, ReviewerId reviewerId) {
    if(this.status != IncidenceStatus.ONGOING) {
      throw new IncidenceDomainException(
          String.format("Transition to rejected state is not valid from %s state", this.status)
      );
    }
    this.status = IncidenceStatus.REJECTED;
    this.review = Review.newReview(reviewId, reason, reviewerId);
  }

  private boolean isNotCancellable() {
    return this.status == IncidenceStatus.CANCELLED || this.status == IncidenceStatus.SOLVED
        || this.status == IncidenceStatus.REPORTED;
  }
}
