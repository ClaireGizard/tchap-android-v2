## Android Studio settings

Please set the "hard wrap" setting of Android Studio to 160 chars, this is the setting we use internally to format the source code (Menu `Settings/Editor/Code Style` then `Hard wrap at`).
Please ensure that you're using the project formatting rules (which are in the project at .idea/codeStyles/), and format the file before committing them.

### Template

An Android Studio template has been added to the project to help creating all files needed when adding a new screen to the application. Fragment, ViewModel, Activity, etc.

To install the template (to be done only once):
- Go to folder `./tools/template`.
- Mac OSX: Run the script `./configure.sh`.

   Linux: Run `ANDROID_STUDIO=/path/to/android-studio ./configure`
    - e.g. `ANDROID_STUDIO=/usr/local/android-studio ./configure`

- Restart Android Studio.

To create a new screen:
- First create a new package in your code.
- Then right click on the package, and select `New/New Vector/Element Feature`.
- Follow the Wizard, especially replace `Main` by something more relevant to your feature.
- Click on `Finish`.
- Remaining steps are described as TODO in the generated files, or will be pointed out by the compiler, or at runtime :)

Note that if the templates are modified, the only things to do is to restart Android Studio for the change to take effect.

## Compilation

For now, the Matrix SDK and the Tchap application are in the same project. So there is no specific thing to do, this project should compile without any special action.

## I want to submit a PR to fix an issue

Please check if a corresponding issue exists. If yes, please let us know in a comment that you're working on it.
If an issue does not exist yet, it may be relevant to open a new issue and let us know that you're implementing it.

### Kotlin

This project is full Kotlin. Please do not write Java classes.

### TCHAP_CHANGES.md

Please add a line to the top of the file `TCHAP_CHANGES.md` describing your change.
### Changelog

Please create at least one file under ./changelog.d containing details about your change. Towncrier will be used when preparing the release.

Towncrier says to use the PR number for the filename, but the issue number is also fine.

Supported filename extensions are:

- ``.feature``: Signifying a new feature in Element Android or in the Matrix SDK.
- ``.bugfix``: Signifying a bug fix.
- ``.doc``: Signifying a documentation improvement.
- ``.removal``: Signifying a deprecation or removal of public API. Can be used to notifying about API change in the Matrix SDK
- ``.misc``: Any other changes.

See https://github.com/twisted/towncrier#news-fragments if you need more details.

### Code quality

Make sure the following commands execute without any error:

#### Internal tool

<pre>
./tools/check/check_code_quality.sh
</pre>

#### ktlint

<pre>
./gradlew ktlintCheck --continue
</pre>

Note that you can run

<pre>
./gradlew ktlintFormat
</pre>

For ktlint to fix some detected errors for you (you still have to check and commit the fix of course)

#### lint

<pre>
./gradlew lintGplayPreprodWithoutvoipWithoutpinningRelease
./gradlew lintFdroidPreprodWithoutvoipWithoutpinningRelease
</pre>

### Unit tests

Make sure the following commands execute without any error:

<pre>
./gradlew testGplayPreprodWithoutvoipWithoutpinningReleaseUnitTest
</pre>

### Tests

Tchap is currently supported on Android Lollipop (API 21+): please test your change on an Android device (or Android emulator) running with API 21. Many issues can happen (including crashes) on older devices.
Also, if possible, please test your change on a real device. Testing on Android emulator may not be sufficient.

You should consider adding Unit tests with your PR, and also integration tests (AndroidTest). Please refer to [this document](./docs/integration_tests.md) to install and run the integration test environment.

### Internationalisation

When adding new string resources, please only add new entries in the 2 files: `value/strings_tchap.xml` and `values-fr/strings_tchap.xml`.
Do not hesitate to use plurals when appropriate.

### Accessibility

Please consider accessibility as an important point. As a minimum requirement, in layout XML files please use attributes such as `android:contentDescription` and `android:importantForAccessibility`, and test with a screen reader if it's working well. You can add new string resources, dedicated to accessibility, in this case, please prefix theirs id with `a11y_`.

For instance, when updating the image `src` of an ImageView, please also consider updating its `contentDescription`. A good example is a play pause button.

### Layout

Also please check that the colors are ok for all the current themes of Tchap. Please use `?attr` instead of `@color` to reference colors in the layout. You can check this in the layout editor preview by selecting all the main themes (`AppTheme.Status`, `AppTheme.Dark`, etc.).

### Authors

Feel free to add an entry in file AUTHORS.md

## Thanks

Thanks for contributing to Tchap projects!
