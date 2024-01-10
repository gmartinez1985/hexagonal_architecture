package com.gfmartinez.hexagonalarchitecture.domain.model.entity;

import com.gfmartinez.hexagonalarchitecture.domain.entity.BaseEntity;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.ReviewId;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.ReviewReason;
import com.gfmartinez.hexagonalarchitecture.domain.model.valueobject.ReviewerId;

public class Review extends BaseEntity<ReviewId> {

  private final ReviewReason reason;
  private final ReviewerId reviewerId;

  private Review(ReviewId reviewId, ReviewReason reason, ReviewerId reviewerId) {
    super.id = reviewId;
    this.reason = reason;
    this.reviewerId = reviewerId;
  }

  public static Review newReview(ReviewId reviewId, ReviewReason reason, ReviewerId reviewerId) {
    return new Review(
      reviewId,
      reason,
      reviewerId
    );
  }

  public ReviewReason getReason() {
    return reason;
  }

  public ReviewerId getReviewerId() {
    return reviewerId;
  }
}
