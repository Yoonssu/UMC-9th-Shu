package com.example.umc9th.domain.mission.entity;

import com.example.umc9th.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Table(name = "usermissions")
@IdClass(UserMissionId.class)
public class UserMission {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", nullable = false)
    private com.example.umc9th.domain.mission.entity.Mission mission;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private Integer progress;

    @Column(nullable = false)
    private LocalDateTime completedAt;

    @Column(nullable = false)
    private LocalDate endAt;

    public enum Status {
        IN_PROGRESS, COMPLETE
    }

    public void complete() {
        this.status = Status.COMPLETE;
        this.completedAt = LocalDateTime.now();
    }

}
