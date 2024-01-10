package com.gfmartinez.hexagonalarchitecture.domain.model.entity;

import com.gfmartinez.hexagonalarchitecture.domain.entity.BaseEntity;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.AttachmentSize;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.AttachmentFileName;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.AttachmentFormat;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.AttachmentId;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.AttachmentUri;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.CreationDate;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.IncidenceId;

public class Attachment extends BaseEntity<AttachmentId> {
  private final CreationDate creationDate;
  private AttachmentFileName fileName;
  private AttachmentFormat format;
  private final IncidenceId incidenceId;
  private AttachmentSize size;
  private AttachmentUri uri;

  private Attachment(AttachmentId attachmentId, AttachmentFileName fileName, AttachmentFormat format, IncidenceId incidenceId,
      AttachmentSize size, AttachmentUri uri) {
    super.id = attachmentId;
    this.fileName = fileName;
    this.format = format;
    this.incidenceId = incidenceId;
    this.size = size;
    this.uri = uri;
    this.creationDate = new CreationDate();
  }

  public static Attachment newAttachment(AttachmentId attachmentId, AttachmentFileName fileName, AttachmentFormat format,
      IncidenceId incidenceId, AttachmentSize size, AttachmentUri uri) {
    return new Attachment(
        attachmentId,
        fileName,
        format,
        incidenceId,
        size,
        uri
    );
  }
  public CreationDate getCreationDate() {
    return creationDate;
  }

  public AttachmentFileName getFileName() {
    return fileName;
  }

  public AttachmentFormat getFormat() {
    return format;
  }

  public IncidenceId getIncidenceId() {
    return incidenceId;
  }

  public AttachmentSize getSize() {
    return size;
  }

  public AttachmentUri getUri() {
    return uri;
  }
}
