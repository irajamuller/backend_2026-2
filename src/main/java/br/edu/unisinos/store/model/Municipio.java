package br.edu.unisinos.store.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter @Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Municipio {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	@Column(length = 50, nullable = false)
	private String nome;

	// Foreign Key
	@ManyToOne(optional = false)
	@JoinColumn(name = "unidadeFederativa", foreignKey = @ForeignKey(name = "fk_municipio_unidadeFederativa"))
	private UnidadeFederativa unidadeFederativa;
	
}
