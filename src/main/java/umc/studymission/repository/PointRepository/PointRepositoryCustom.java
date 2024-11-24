package umc.studymission.repository.PointRepository;

import umc.studymission.domain.mapping.Point;

import java.util.List;

public interface PointRepositoryCustom {
    List<Point> findPointsByDynamicCriteria(Long userId, Long missionId);
}
