package com.it4us.todoapp.repository;

import com.it4us.todoapp.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Optional<Board> findByName(String name);

    @Query(value = "SELECT * FROM boards b where b.workspace_id = :workspaceId", nativeQuery = true)
    List<Board> findBoardsByWorkspaceId(@Param("workspaceId")Long workspaceId);

    @Query(value = "SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM boards b where b.workspace_id = :workspaceId and b.board_name= :boardName", nativeQuery = true)
    Boolean isBoardExistInWorkSpace(@Param("boardName")String boardName, @Param("workspaceId")Long workspaceId);

    List<Board> findByWorkspaceId(Optional<Long> workspaceId);

    @Query(value = "select count(*) from workspaces where user_id= (select user_id from users where username= :username ) and workspace_id= (select workspace_id from boards where board_id = :boardId )", nativeQuery = true)
    int isBoardBelongedUser(@Param("boardId") Long boardId, @Param("username") String username);
}
