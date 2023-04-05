package pojos;

public class JsonPlaceHolderPojo {
    /*
     1) Create private variables for every key
     2) Create constructors with all parameters and without any parameter
     3) Create public getters and setters for all variables.
     4) Create toString
     */
    private Integer userId;
    private String title;
    private Boolean completed;

    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }
    public JsonPlaceHolderPojo(){

    }

    public Integer getUserId() {

        return userId;
    }

    public void setUserId(Integer userId) {

        this.userId = userId;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}




