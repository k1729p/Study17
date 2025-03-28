package kp.mappers.samples.builders;

/**
 * Represents the 'top/left' position.
 */
public class Top {

    private final String left;

    /**
     * Gets the left.
     *
     * @return the left
     */
    public String getLeft() {
        return left;
    }

    /**
     * Parameterized constructor.
     *
     * @param builder the {@link Top.Builder}
     */
    protected Top(Top.Builder builder) {
        this.left = builder.left;
    }

    /**
     * Retrieves the builder.
     *
     * @return the {@link Top.Builder}
     */
    public static Top.Builder builder() {
        return new Top.Builder();
    }

    /**
     * The builder class for Top.
     */
    public static class Builder {

        private String left;

        /**
         * Default constructor.
         */
        public Builder() {
            // constructor is empty
        }

        /**
         * Sets the left
         *
         * @param left the left
         * @return the builder
         */
        public Builder left(String left) {
            this.left = left;
            return this;
        }

        /**
         * Creates a Top instance.
         *
         * @return the {@link Top}
         */
        public Top create() {
            return new Top(this);
        }
    }

}
