package com.bng.ddaja.common.domain;

import java.util.List;

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
 
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor; 
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false, of = "id")
@Table(name = "TB_DEBATE")
@NoArgsConstructor
@Entity
public class Debate extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="D_ID")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Q_ID")
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "U_ID")
    private User user;

    @OneToMany(mappedBy = "debate")
    private List<DebateComment> debateComments;

    public void setQuestion(Question question) {
        if(this.question != null) {
            question.getDebates().remove(this);
        }
        this.question = question;
        if(!question.getDebates().contains(this)) {
            question.setDebate(this);
        }
    }

    public void setUser(User user) {
        if(this.user != null) {
            user.getDebates().remove(this);
        }
        this.user = user;
        if(!user.getDebates().contains(this)) {
            user.setDebate(this);
        }
    }

    public void setDebateComment(DebateComment debateComment) {
        this.debateComments.add(debateComment);
        if(debateComment.getDebate() != this) {
            debateComment.setDebate(this);
        }
    }
}
