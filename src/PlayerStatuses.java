/**
 * PlayerStauses.java
 *
 * This enumeration contains the different statuses that can be set for any character in the game.
 *
 * @author Wyatt Fisher
 * @since 3.23.21
 *
 */
public enum PlayerStatuses {
    HEALTHY {
        @Override
        public String toString() { return "Healthy"; }
    },
    FATIGUED {
        @Override
        public String toString() { return "Fatigued"; }
    },
    SICK_CHOLERA {
        @Override
        public String toString() { return "Cholera"; }
    },
    SICK_MALARIA {
        @Override
        public String toString() { return "Malaria"; }
    },
    SICK_SMALLPOX {
        @Override
        public String toString() { return "Smallpox"; }
    },
    FREEZING {
        @Override
        public String toString() { return "Freezing"; }
    },
    DEAD {
        @Override
        public String toString() { return "Dead"; }
    }
}
