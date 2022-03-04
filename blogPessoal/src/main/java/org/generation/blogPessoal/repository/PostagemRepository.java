package org.generation.blogPessoal.repository;

import java.util.List;


import org.generation.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**	 Classes Repositorys são as classes que farão a persistencia de dados da nossa aplicação
 *	Os repositorios também farão parte da camada de negocios da nossa aplicação, fornecendo objetos a outras camadas como as de controle ou visão

 **/

/** Repositoy  é a anotação spring que indica que a class é um repositoio.
 * JPA é uma api que padroniza um conjunto de classes e metodos que devem ser implementados
 *
 **/
@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);

}
