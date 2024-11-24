package umc.studymission.repository.PointRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.studymission.domain.mapping.Point;

public interface PointRepository extends JpaRepository<Point, Long>, PointRepositoryCustom {
}
