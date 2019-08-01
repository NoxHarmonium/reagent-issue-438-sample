# reagent-issue-438-sample

A sample project to reproduce [Reagent issue #438](https://github.com/reagent-project/reagent/issues/438)
so a fix can be verified.

### Standard Browsers

Run:

    $ lein figwheel

Navigate to http://localhost:3449/index.html

Expected: Page renders and counter increments

#### Firefox

Passes ✔️

#### Chrome

Passes ✔️

### Browser Extensions

Run:

    $ lein clean
    $ lein with-profile prod compile

Load as extension (debug/unpacked)

Navigate to http://www.example.com (extension is restricted to only run on that page)

Expected: Page renders and counter increments.

#### Firefox

Fails ❌

Rendering loop stops. Checking the Browser Console (CTRL + SHIFT + J) shows:

    TypeError: 'requestAnimationFrame' called on an object that does not implement interface Window.

#### Chrome

Passes ✔️
