package com.example.umc9th.domain.mission.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserMissionId implements Serializable {
    private Long member;
    private Long mission;
}
