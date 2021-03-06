package hypr.a255bits.com.hypr

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Test



/**
 * Created by ted on 7/17/17.
 */

class GettingImageFromGallery{
    val context: Context = mock()
    val view: MainMvp.view = mock()
    val interactor: MainInteractor = mock()

    val presenter: MainPresenter = MainPresenter(context, view, interactor)

    @Test
    fun clickingButtonOpensGallery(){
        presenter.displayGallery()
        verify(view).displayGallery()
    }

    @Test
    fun getImageFromGalleryImageChosen(){
        val imageLocation: Uri = mock()
        val conf = Bitmap.Config.ARGB_8888
        val bitmap: Bitmap = any()

        presenter.getImageFromImageFileLocation(imageLocation)

        whenever(interactor.uriToBitmap(imageLocation)).thenReturn(bitmap)
        verify(view).displayFocusedImage(bitmap)



    }
}
