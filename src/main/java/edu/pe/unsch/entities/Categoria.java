package edu.pe.unsch.entities;
// Generated 25/06/2019 10:02:18 PM by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Categoria generated by hbm2java
 */
@Entity
@Table(name = "categoria", catalog = "ecommerceremate")
public class Categoria implements java.io.Serializable {

	private Integer id;
	private String nombre;
	private Boolean visible;
	private Integer categoriapadre;
	private Set<Producto> productos = new HashSet<Producto>(0);
	private Set<Categoria> categories;
	public Categoria() {
	}

	public Categoria(String nombre, Boolean visible, Integer categoriapadre, Set<Producto> productos) {
		this.nombre = nombre;
		this.visible = visible;
		this.categoriapadre = categoriapadre;
		this.productos = productos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nombre", length = 40)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "visible")
	public Boolean getVisible() {
		return this.visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	@Column(name = "categoriapadre")
	public Integer getCategoriapadre() {
		return this.categoriapadre;
	}

	public void setCategoriapadre(Integer categoriapadre) {
		this.categoriapadre = categoriapadre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
	public Set<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
	@OneToMany
	@JoinColumn(name = "categoriapadre", referencedColumnName = "id")
	public Set<Categoria> getCategories() {
		return categories;
	}

	public void setCategories(Set<Categoria> categories) {
		this.categories = categories;
	}
	

}
