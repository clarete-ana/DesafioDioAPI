package me.dio.DesafioApi.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "tb_task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Boolean done;
    private LocalDate deadline;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    public Task() {
    }

    public Task(Long id, String title, String description, Boolean done, LocalDate deadline) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.done = done;
        this.deadline = deadline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
