package com.sample.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "todo")
public class TodoEntity {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(columnDefinition = "BINARY(16)")
  private UUID id;

  private String userId;
  private String title;
  private boolean done;

  @Builder
  public TodoEntity(String userId, String title, boolean done) {
    this.userId = userId;
    this.title = title;
    this.done = done;
  }

  @PostLoad
  public void onPostLoad() {}

  @PrePersist
  public void onPrePersist() {}

  @PostPersist
  public void onPostPersist() {}

  @PreUpdate
  public void onPreUpdate() {}

  @PostUpdate
  public void onPostUpdate() {}

  @PreRemove
  public void onPreRemove() {}

  @PostRemove
  public void onPostRemove() {}
}
