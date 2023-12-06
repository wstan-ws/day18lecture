package vttp.iss.day18lecture.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Announcement {

    @NotNull(message = "ID is mandatory")
    @Digits(fraction = 0, integer = 9, message = "Only numbers allowed")
    private Integer annId;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "Only alphabets allowed")
    private String code;

    @NotEmpty(message = "Title is mandatory")
    @Size(min = 10, max = 50, message = "Title must be between 10 and 50 characters")
    private String title;

    @NotEmpty(message = "Message is mandatory")
    private String message;

    @Future(message = "Start date must be in the future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    public Integer getAnnId() {
        return annId;
    }

    public void setAnnId(Integer annId) {
        this.annId = annId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    public Announcement() {
    }

    @Override
    public String toString() {
        return "Announcement [annId=" + annId + ", code=" + code + ", title=" + title + ", message=" + message
                + ", startDate=" + startDate + "]";
    }

    
}
