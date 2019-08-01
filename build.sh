#!/usr/bin/env bash

lein clean
lein with-profile prod compile
npx web-ext run