package project.android.imageprocessing.filter.effect;import project.android.imageprocessing.filter.GroupFilter;import project.android.imageprocessing.filter.processing.GaussianBlurFilter;/** * This uses a similar process as the GPUImageToonFilter, only it precedes the toon effect with a Gaussian blur to smooth out noise. * blurSize: A multiplier for the prepass blur size, ranging from 0.0 on up * threshold: The sensitivity of the edge detection, with lower values being more sensitive. Ranges from 0.0 to 1.0 * quantizationLevels: The number of color levels to represent in the final image. * @author Chris Batt */public class SmoothToonFilter extends GroupFilter {	public SmoothToonFilter(float blurSize, float threshold, float quantizationLevels) {		GaussianBlurFilter blur = new GaussianBlurFilter(blurSize);		ToonFilter toon = new ToonFilter(threshold, quantizationLevels);		blur.addTarget(toon);		toon.addTarget(this);				registerInitialFilter(blur);		registerTerminalFilter(toon);	}}