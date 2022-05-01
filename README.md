# BitmapExtensions
[![](https://jitpack.io/v/entan05/BitmapExtensions.svg)](https://jitpack.io/#entan05/BitmapExtensions) [![](https://badgen.net/badge/license/Apache%20License%202.0/blue)]() [![](https://badgen.net/badge/target/Android/green)]() [![](https://badgen.net/badge/minSdkVersion/24/B94047)]()
[![](https://badgen.net/badge/OpenCV/4.5.5/cyan)](https://opencv.org/)

## このリポジトリについて
画像処理の勉強がてら、色々な画像処理をAndroidのライブラリとして公開

## 導入方法
１. rootの`build.gradle`に以下を記載
```
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
※ `allprojects{ repositories{ } }`がない場合は`settings.gradle`に以下を記載
```
dependencyResolutionManagement {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
２. `app/build.gradle`に以下を記載
```
dependencies {
    // 全てのライブラリモジュールを取り込む場合
    implementation 'com.github.entan05:BitmapExtensions:$VERSION'

    // 特定のライブラリモジュールのみを取り込む場合
    implementation 'com.github.entan05.BitmapExtensions:$MODULE:$VERSION'
}
```

## モジュールについて
TBD
