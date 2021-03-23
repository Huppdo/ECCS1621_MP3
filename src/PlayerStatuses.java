/**
 * This enumeration contains the different statuses that can be set for any character in the game.
 */
public enum PlayerStatuses {
    Healthy, Fatigued, Sick_Cholera {
        @Override
        public String toString() { return "Cholera"; }
    }, Sick_Malaria {
        @Override
        public String toString() { return "Malaria"; }
    }, Sick_Smallpox {
        @Override
        public String toString() { return "Smallpox"; }
    }, Freezing, Dead
}
