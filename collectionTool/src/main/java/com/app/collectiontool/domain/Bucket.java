package com.app.collectiontool.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "bucket")
public class Bucket {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    long bucketId;

    String bucketName;

    private final String baseUrl;

    public Bucket(Long bucketId, String bucketName, String baseUrl){
        this.bucketId = bucketId;
        this.bucketName=bucketName;
        this.baseUrl = baseUrl;
    }

    public String getUrl() {
        return baseUrl + "/" + bucketId;
    }

}
