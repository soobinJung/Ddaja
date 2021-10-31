package com.bng.ddaja.common.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false, of = "id")
@Table(name = "TB_DEBATE_COMMENT")
@NoArgsConstructor
@Entity
public class DebateComment extends CommonEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DC_ID")
    private long id;

    @Column(name="CONTENT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "D_ID")
    private Debate debate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "U_ID")
    private User user;

    public void setDebate(Debate debate) {
        if(this.debate != null) {
            this.debate.getDebateComments().remove(this);
        }
        this.debate = debate;
        if(!debate.getDebateComments().contains(this)) {
            debate.setDebateComment(this);
        }
    }

    public void setUser(User user) {
        if(this.user != null) {
            this.user.getDebateComments().remove(this);
        }
        this.user = user;
        if(!user.getDebateComments().contains(this)) {
            user.setDebateComment(this);
        }
    }
}
