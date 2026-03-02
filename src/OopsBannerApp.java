public class OopsBannerApp {
    static class CharacterPatternMap {
        private Character character;
        private String[] pattern;
        public CharacterPatternMap(Character character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }
        public Character getCharacter() {
            return character;
        }
        public String[] getPattern() {
            return pattern;
        }
    }
    public static CharacterPatternMap[] createCharacterPatternMaps() {
        CharacterPatternMap[] charMaps = new CharacterPatternMap[4];
        String[] O = {
            "   ***   ",
            " **   ** ",
            "**     **",
            "**     **",
            "**     **",
            "**     **",
            "**     **",
            " **   ** ",
            "   ***   "
        };
        String[] P = {
            "******   ",
            "**    ** ",
            "**     **",
            "**    ** ",
            "******   ",
            "**       ",
            "**       ",
            "**       ",
            "**       "
        };
        String[] S = {
            "   ***** ",
            " **      ",
            "**       ",
            " **      ",
            "   ***   ",
            "      ** ",
            "       **",
            "      ** ",
            " *****   "
        };
        String[] space = {
                "   ",
                "   ",
                "   ",
                "   ",
                "   ",
                "   ",
                "   "
        };
        charMaps[0] = new CharacterPatternMap('O', O);
        charMaps[1] = new CharacterPatternMap('P', P);
        charMaps[2] = new CharacterPatternMap('S', S);
        charMaps[3] = new CharacterPatternMap(' ', space);
        return charMaps;
    }
    public static String[] getCharacterPattern(char ch,
            CharacterPatternMap[] charMaps) {
        for (CharacterPatternMap map : charMaps) {
            if (map.getCharacter() == ch) {
                return map.getPattern();
            }
        }
        return getCharacterPattern(' ', charMaps);
    }
    public static void printMessage(String message,
            CharacterPatternMap[] charMaps) {
        for (int row = 0; row < 9; row++) {
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                String[] pattern =
                        getCharacterPattern(message.charAt(i), charMaps);
                line.append(pattern[row]).append("  ");
            }
            System.out.println(line.toString());
        }
    }
    public static void main(String[] args) {
        CharacterPatternMap[] charMaps =
                createCharacterPatternMaps();
        String message = "OOPS";
        printMessage(message, charMaps);
    }
}