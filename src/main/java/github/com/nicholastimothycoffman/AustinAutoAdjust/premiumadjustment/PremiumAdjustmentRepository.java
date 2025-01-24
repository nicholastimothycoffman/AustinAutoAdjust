import org.springframework.data.jpa.repository.JpaRepository;

public interface PremiumAdjustmentRepository extends JpaRepository<PremiumAdjustment, Long> {
    // Custom database queries can be defined here
}

