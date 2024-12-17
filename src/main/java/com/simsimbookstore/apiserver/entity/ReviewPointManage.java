package com.simsimbookstore.apiserver.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "review_point_manages")
public class ReviewPointManage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_point_id")
    private Long reviewPointId;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "review_id", nullable = false)
//    private Review review;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "point_history_id", nullable = false)
    private PointHistory pointHistory;

    @Builder
    public ReviewPointManage(Long reviewPointId,
//                             Review review,
                             PointHistory pointHistory) {
        this.reviewPointId = reviewPointId;
//        this.review = review;
        this.pointHistory = pointHistory;
    }
}