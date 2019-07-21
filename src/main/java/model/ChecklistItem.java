package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

public class ChecklistItem {

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

    @Data
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    public class ChecklistItem implements IBaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private boolean completed;
        private String name;
        private String description;
        @Enumerated(EnumType.STRING)
        private status status;

        @ManyToOne
        private Checklist checklist;

    }

}
