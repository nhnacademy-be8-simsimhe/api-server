package com.simsimbookstore.apiserver.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "coupon_types")
public class CouponType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_type_id")
    private Long couponTypeId;

    @Column(name = "coupon_type_name", length = 40, nullable = false)
    private String couponTypeName;

    @Column(name = "period")
    private Integer period;

    @Column(name = "deadline")
    private LocalDateTime deadline;

    @Column(name = "coupon_stacking",nullable = false)
    private Boolean couponStacking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_policy_id",nullable = false)
    private CouponPolicy couponPolicy;

    @Enumerated(EnumType.STRING)
    @Column(name = "coupon_target_type",nullable = false)
    private CouponTargetType couponTargetType;

    @Builder
    public CouponType(Long couponTypeId, String couponTypeName, Integer period, LocalDateTime deadline, Boolean couponStacking, CouponPolicy couponPolicy, CouponTargetType couponTargetType) {
        this.couponTypeId = couponTypeId;
        this.couponTypeName = couponTypeName;
        this.period = period;
        this.deadline = deadline;
        this.couponStacking = couponStacking;
        this.couponPolicy = couponPolicy;
        this.couponTargetType = couponTargetType;
    }


    public enum CouponTargetType {
        ALL, CATEGORY, BOOK
    }
}