package umc.study.web.dto;

public class ReviewResponse {

    private Long reviewId;
    private int rating;
    private String comment;

    public ReviewResponse(Long reviewId, int rating, String comment) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.comment = comment;
    }

    // Getters and setters
    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
