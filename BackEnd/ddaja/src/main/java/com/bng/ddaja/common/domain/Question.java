package com.bng.ddaja.common.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table; 
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Table(name = "TB_QUESTION")
@NoArgsConstructor
@Entity
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Q_ID")
    private long id;
    
    @Column(name="TITLE")
    private String title;

    @Column(name="CONTENT")
    private String content;

    @Column(name="SCORE")
    private long score;

    @Column(name="NO")
    private long no;

    @Column(name="ANSWER_ONE")
    private String ANSWER_ONE;

    @Column(name="ANSWER_TWO")
    private String ANSWER_TWO;

    @Column(name="ANSWER_THR")
    private String ANSWER_THR;

    @Column(name="ANSWER_FOUR")
    private String ANSWER_FOUR;

    @Column(name="ANSWER_FIVE")
    private String ANSWER_FIVE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "L_ID")
    private License license;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "S_ID")
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "R_ID")
    private Round round;

    @OneToMany(mappedBy = "question")
    private List<StateQuestion> stateQuestions;

    @OneToMany(mappedBy = "question")
    private List<Debate> debates;

    @OneToMany(mappedBy = "question")
    private List<DebateState> debateStates;

    public void setSubject(Subject subject) {
        if(this.subject != null) {
            this.subject.getQuestions().remove(this);
        }
        this.subject = subject;
        if(!subject.getQuestions().contains(this)) {
            subject.setQuestion(this);
        }
    }

    public void setRound(Round round) {
        if(this.round != null) {
            this.round.getQuestions().remove(this);
        }
        this.round = round;
        if(!round.getQuestions().contains(this)) {
            round.setQuestion(this);
        }
    }

    public void setLicense(License license) {
        if(this.license != null) {
            this.license.getQuestions().remove(this);
        }
        this.license = license;
        if(!license.getQuestions().contains(this)) {
            license.setQuestion(this);
        }
    }

    public void setStateQuestion(StateQuestion stateQuestion){
        this.stateQuestions.add(stateQuestion);
        if(stateQuestion.getQuestion() != this) {
            stateQuestion.setQuestion(this);
        }
    }

    public void setDebate(Debate debate) {
        this.debates.add(debate);
        if(debate.getQuestion() != this) {
            debate.setQuestion(this);
        }
    }

    public void setDebateState(DebateState debateState) {
        this.debateStates.add(debateState);
        if(debateState.getQuestion() != this) {
            debateState.setQuestion(this);
        }
    }
}
