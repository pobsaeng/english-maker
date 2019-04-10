package com.web.english.models
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table
data class Categories(
//        @Id @GeneratedValue(generator="system-uuid")
//        @GenericGenerator(name="system-uuid", strategy = "uuid")
        @Id
        @GeneratedValue(strategy = GenerationType.TABLE)
        val CategoryId: Long? = null,
        val CategoryName: String? = ""
)