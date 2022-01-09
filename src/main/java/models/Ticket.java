package models;

import java.util.Objects;

/** Объект тикета */
public class Ticket {

    /** Название проблемы */
    private String queue; // todo: остальные поля необходимые для заполнения тикета
    private String title;
    private String description;
    private int priority;
    private String email;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQueue() { // todo: методы get и set для остальных полей
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) { // todo: equals и hashCode
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return priority == ticket.priority && Objects.equals(queue, ticket.queue) && Objects.equals(title, ticket.title) && Objects.equals(description, ticket.description) && Objects.equals(email, ticket.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(queue, title, description, priority, email);
    }


}
