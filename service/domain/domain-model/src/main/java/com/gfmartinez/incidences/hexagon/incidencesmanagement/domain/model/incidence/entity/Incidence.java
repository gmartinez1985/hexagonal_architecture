package com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.entity;

import com.gfmartinez.hexagonalarchitecture.domain.entity.AggregateRoot;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.attachment.entity.Attachment;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.review.entity.Review;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.exception.IncidenceDomainException;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.attachment.valueobjects.AttachmentFileName;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.attachment.valueobjects.AttachmentFormat;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.attachment.valueobjects.AttachmentId;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.attachment.valueobjects.AttachmentSize;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.attachment.valueobjects.AttachmentUri;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects.ClientId;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.shared.valueobjects.CreationDate;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects.Duration;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects.FinalizationDate;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects.IncidenceDescription;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects.IncidenceHeader;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.shared.valueobjects.IncidenceId;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects.IncidenceSeverity;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects.IncidenceStatus;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects.RepairerId;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects.ReportId;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects.ReporterId;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects.ReviewId;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.review.valueobjects.ReviewReason;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.review.valueobjects.ReviewerId;
import com.gfmartinez.incidences.hexagon.incidencesmanagement.domain.model.incidence.valueobjects.Version;
import java.util.UUID;
import lombok.Builder;

@Builder
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
