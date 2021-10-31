package com.bng.ddaja.common.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bng.ddaja.common.enums.DebateStateType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false, of = "id")
@Table(name = "TB_DEBATE_STATE")
@NoArgsConstructor
@Entity
public class DebateState extends CommonEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DS_ID")
    private long id;

    @Enumerated(EnumType.STRING)
    private DebateStateType state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Q_ID")
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "U_ID")
    private User user;

    public void setQuestion(Question question) {
        if(this.question != null) {
            this.question.getDebateStates().remove(this);
        }
        this.question = question;
        if(!question.getDebateStates().contains(this)) {
            question.setDebateState(this);
        }
    }

    public void setUser(User user) {
        if(this.user != null) {
            this.user.getDebateStates().remove(this);
        }
        this.user = user;
        if(!user.getDebateStates().contains(this)) {
            user.setDebateState(this);
        }
    }
}
