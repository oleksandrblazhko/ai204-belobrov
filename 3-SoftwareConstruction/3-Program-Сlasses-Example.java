/*
 * This file represents planty of merged .java programm files available by the [link](https://drive.google.com/drive/folders/1zOPnPmkSaGPDa4gDe7Ejf_KCQFnMAbQV?usp=sharing).
 */
 
 package com.nuop.tscp.model.genre;

import com.nuop.tscp.model.literature.Literature;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "genres")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Genre {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "genre_id")
  private Long id;

  private String name;

  @ManyToMany(mappedBy = "genres")
  private Set<Literature> literature;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Genre genre = (Genre) o;
    return Objects.equals(id, genre.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public void addLiterature(Literature literature) {
    this.literature.add(literature);
  }
}

package com.nuop.tscp.model.literature;

import com.nuop.tscp.model.genre.Genre;
import com.nuop.tscp.model.literature_type.LiteratureType;
import com.nuop.tscp.model.user.User;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "literatures")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Literature {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "literature_id")
  private Long id;

  private String name;
  private String description;
  private Double cost;

  @ManyToOne
  @JoinColumn(name = "author_id")
  private LiteratureType literatureType;

  @ManyToOne
  @JoinColumn(name = "author_id", insertable = false, updatable = false)
  private User author;

  @ManyToMany
  @JoinTable(name = "literature_genres",
    joinColumns = @JoinColumn(name = "literature_id"),
    inverseJoinColumns = @JoinColumn(name = "genre_id"))
  private Set<Genre> genres;

  @ManyToMany
  @JoinTable(name = "literature_users",
      joinColumns = @JoinColumn(name = "literature_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id"))
  private Set<User> users;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Literature that = (Literature) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public void addGenre(Genre genre) {
    genres.add(genre);
  }

  public void addUser(User user) {
    users.add(user);
  }
}

package com.nuop.tscp.model.literature_type;

import com.nuop.tscp.model.literature.Literature;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "literature_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LiteratureType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "literature_type_id")
  private Long id;

  @Column(unique = true)
  private String name;

  @OneToMany(mappedBy = "literatureType")
  private Set<Literature> literature;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LiteratureType that = (LiteratureType) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public void addLiterature(Literature literature) {
    this.literature.add(literature);
  }
}

package com.nuop.tscp.model.user;

import com.nuop.tscp.model.literature.Literature;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long id;

  private String role;
  private String name;
  private String surname;
  private String patronymic;

  private Double balance = 0D;

  @Column(unique = true)
  private String email;

  @Column(unique = true)
  private String mobile;

  @ManyToMany(mappedBy = "users")
  Set<Literature> literature = new HashSet<>();

  @OneToMany(mappedBy = "author")
  private Set<Literature> ownLiterature = new HashSet<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(id, user.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public void addLiterature(Literature literature) {
    this.literature.add(literature);
  }

  public void addOwnLiterature(Literature literature) {
    ownLiterature.add(literature);
  }
}
