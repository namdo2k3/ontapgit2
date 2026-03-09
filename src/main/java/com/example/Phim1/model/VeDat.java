package com.example.Phim1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ve_dat")
public class VeDat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nguoi_dat")
    private String nguoiDat;

    @Column(name = "so_luong_ve")
    private Integer soLuongVe;

    @Column(name = "ngay_chieu")
    private String ngayChieu;

    @Column(name = "da_thanh_toan")
    private Boolean daThanhToan;

    @ManyToOne
    @JoinColumn(name = "id_phim", referencedColumnName = "id")
    private Phim phim;
}
