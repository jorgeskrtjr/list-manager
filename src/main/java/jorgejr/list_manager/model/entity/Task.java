package jorgejr.list_manager.model.entity;

import jakarta.persistence.*;
import jorgejr.list_manager.model.dto.TaskInput;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String titulo;

    @Column
    private String descricao;

    @Column(name = "data_criacao", columnDefinition = "TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dataCriacao;

    @Column(name = "data_conclusao")
    private LocalDateTime dataConclusao;

    @Column
    private Boolean concluida = false;

    @ManyToOne
    @JoinColumn(name = "task_list_id")
    private TaskList taskList;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public Boolean getConcluida() {
        return concluida;
    }

    public void setConcluida(Boolean concluida) {
        this.concluida = concluida;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    public Task(TaskInput input){
        this.titulo = input.titulo();
        this.descricao = input.descricao();
        this.dataCriacao = LocalDateTime.now();
        this.dataConclusao = null;
        this.concluida = false;
    }

    public void update(TaskInput input){

        if(input.titulo() != null){
             this.titulo = input.titulo();
      }

        if(input.descricao() != null){
            this.descricao = input.descricao();
        }

    }
}