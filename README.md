# Unifont

This “library” binds the baked bitmap of Unifont, so we don’t need to add them for each project.

## Import

```groovy
dependencies {
    implementation(platform("io.github.over-run:utilities:+"))
    implementation("io.github.over-run:unifont")
}
```

## Technical Information

The constants are stored in `UnifontUtil`.
