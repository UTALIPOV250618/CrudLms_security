package peaksoft.crudlms_security.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "groupSet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String group_name;

    @ManyToMany
            (mappedBy = "groupSet")
    private Set<Course> courses;

    @OneToMany(mappedBy = "group")
    private List<Student> students;
}
