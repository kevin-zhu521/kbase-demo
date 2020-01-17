package com.kbase.demo.test;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author kevin.zhu
 * @date 2019/12/26 15:32
 */
public class zhujinfantest {
    public static void main(String[] args) {
        List<Student> lists = Lists.newArrayList();
        lists.add(Student.builder().name("zhu").age("11").build());
        lists.add(Student.builder().name("aa").age("22").build());

//        Student s3 = Student.builder().name("zhu").age("11").build();
        Student s3 = null;
        List<String> names = Optional.ofNullable(s3).map(student -> {
            List<String> list1 = Lists.newArrayList();
            list1.add(student.getName());
            return list1;
        }).get();
        System.out.println(names);

    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Student {
    private String name;
    private String age;
}
