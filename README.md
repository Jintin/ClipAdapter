# ClipAdapter

ClipAdapter help you to build scalable Adapter easily.
Though we have things like ConcatAdapter today to help us merge different Adapter into one, it still not flexible enough for us to randomly mix different Data/ViewHolder into same Adapter without adding new viewType and also how to create ViewHolder.

With ClipAdapter, you can compose any kind of Data with any ViewHolder together easily.

## Install

Add [Jitpack](https://jitpack.io/) repository to your root `build.grable`:
```groovy
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

Then add dependency in your module `build.gradle`:
```groovy
dependencies {
  implementation 'com.github.jintin:ClipAdapter:1.0.0'
}
```

## Usage

1. Create you `ViewHolder` with `ClipViewHolder` as base class, ie:
```kotlin
class StringHolder(itemView: View) : ClipViewHolder<String>(itemView) {

    private val title = itemView.findViewById<TextView>(R.id.title)

    override fun onBind(value: Char) {
        title.text = value.toString()
    }
}
```

2. Wrap your data with `ClipViewData` interface and also provide how to create corresponding `ViewHolder`, ie:

```kotlin
class StringViewData(override val value: String) : ClipViewData<String> {

    override val holderProvider: ViewHolderProvider<String> = {
        StringHolder(
            LayoutInflater.from(it.context)
                .inflate(R.layout.adapter_string, it, false)
        )
    }
}
```

It's also possible to use `ViewBinding`, just change your `ViewHolder` constructor from `View` to the correct ViewBinding and generate the `ViewHolder` via the same ViewBinding, ie:

```kotlin
class StringViewData(override val value: String) : ClipViewData<String> {

    override val holderProvider: ViewHolderProvider<String> = {
        StringHolder(
            AdapterStringBinding.inflate(
                LayoutInflater.from(it.context),
                it,
                false
            )
        )
    }
}

class StringHolder(private val binding: AdapterStringBinding) :
    ClipViewHolder<String>(binding.root) {

    override fun onBind(value: String) {
        binding.title.text = value
    }
}
```

3. Use `ClipAdapter` for `RecyclerView` and pass the data via `submitList` as [ListAdapter](https://developer.android.com/reference/androidx/recyclerview/widget/ListAdapter) does.

```kotlin
val adapter = ClipAdapter()
val data = listOf<ClipViewData<*>>(...)
adapter.submitList(data)

```

You can go to ./app module for more information.

## Contributing
Bug reports and pull requests are welcome on GitHub at [https://github.com/Jintin/ClipAdapter](https://github.com/Jintin/ClipAdapter).

## License
The package is available as open source under the terms of the [MIT License](http://opensource.org/licenses/MIT).

[![Buy Me A Coffee](https://www.buymeacoffee.com/assets/img/custom_images/orange_img.png)](https://www.buymeacoffee.com/jintin)
