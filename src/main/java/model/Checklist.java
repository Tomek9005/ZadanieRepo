package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class Checklist {

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

    @Data
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    public class Checklist implements IBaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String name;
        @CreationTimestamp
        // jest to adnotacja, która umieszcza wewnątrz pola dateCreated, datę wstawienia rekordu do bazy
        private LocalDateTime dateCreated;
        private LocalDateTime dateCompleted;
        private boolean archived;

        @OneToMany(mappedBy = "checklist", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
        @Cascade(org.hibernate.annotations.CascadeType.DELETE)
        private List<ChecklistItem> checklistItems;

        public Checklist(String name) {
            this.name = name;
        }
    }

}
