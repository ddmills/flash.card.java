package flash.card.java.model;

public interface StudentInterface {
    int getUserID ();
    boolean addQuiz (Quiz q);
    boolean removeQuiz(Quiz q);
}
