/**
Holds enum representations of all the stops that can appear on the map

@since 3.23.21
@author Dominic Hupp
*/

public enum Landmarks {
    NONE,
    START,
    INDEPENDENCE_ROCK {

        @Override
        public String toString() {
            return "Independence Rock";
        }
    },
    RIVER,
    FORT_BRIDGER {
        @Override
        public String toString() {
            return "Fort Bridger";
        }
    },
    FORT_HALL {

        @Override
        public String toString() {
            return "Fort Hall";
        }
    },
    FORT_BOISE {

        @Override
        public String toString() {
            return "Fort BOISE";
        }
    },
    OREGON_CITY {

        @Override
        public String toString() {
            return "Oregon City";
        }
    }

}
