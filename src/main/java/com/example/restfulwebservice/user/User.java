package com.example.restfulwebservice.user;

import com.example.restfulwebservice.post.Post;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
//@JsonIgnoreProperties(value = {"password"})
@NoArgsConstructor
//@ApiModel(description = "사용자 상세 정보를 위한 도메인 객체")
//@JsonFilter("UserInfo")
@Entity
@Table(name = "users")
public class User {

    public User(Long id, String name, Date joinDate, String password, String ssn) {
        this.id = id;
        this.name = name;
        this.joinDate = joinDate;
        this.password = password;
        this.ssn = ssn;
    }

    public User(String name, Date joinDate, String password, String ssn) {
        this.name = name;
        this.joinDate = joinDate;
        this.password = password;
        this.ssn = ssn;
    }

    @Id @GeneratedValue
    private Long id;

    @Size(min = 2, message = "Name은 2글자 이상 입력해 주세요.")
//    @ApiModelProperty(notes = "사용자 이름을 입력해 주세요.")
    @Column(name = "user_name")
    private String name;
    @Past
//    @ApiModelProperty(notes = "사용자의 등록일 입력해 주세요")
    private Date joinDate;
//    @ApiModelProperty(notes = "사용자의 패스워드를 입력해 주세요")
    private String password;
//    @ApiModelProperty(notes = "사용자의 주민번호를 입력해 주세요")
    private String ssn; // 주민번호

    @OneToMany(mappedBy = "user")
    private List<Post> posts;
}
