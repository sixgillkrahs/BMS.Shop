import React from 'react'
import './Size.css'
import './Size.scss'

const Size = () => {
  return (
    <div>
        <div class="sidebar__sizes">
            <div class="section-title">
                <h4>Shop by size</h4>
            </div>
            <div class="size__list">
                <label for="xxs">
                    xxs
                    <input type="checkbox" id="xxs"/>
                    <span class="checkmark"></span>
                </label>
                <label for="xs">
                    xs
                    <input type="checkbox" id="xs"/>
                    <span class="checkmark"></span>
                </label>
                <label for="xss">
                    xs-s
                    <input type="checkbox" id="xss"/>
                    <span class="checkmark"></span>
                </label>
                <label for="s">
                    s
                    <input type="checkbox" id="s"/>
                    <span class="checkmark"></span>
                </label>
                <label for="m">
                    m
                    <input type="checkbox" id="m"/>
                    <span class="checkmark"></span>
                </label>
                <label for="ml">
                    m-l
                    <input type="checkbox" id="ml"/>
                    <span class="checkmark"></span>
                </label>
                <label for="l">
                    l
                    <input type="checkbox" id="l"/>
                    <span class="checkmark"></span>
                </label>
                <label for="xl">
                    xl
                    <input type="checkbox" id="xl"/>
                    <span class="checkmark"></span>
                </label>
            </div>
        </div>
        <div class="sidebar__color">
            <div class="section-title">
                <h4>Shop by color</h4>
            </div>
            <div class="size__list color__list">
                <label for="black">
                    Blacks
                    <input type="checkbox" id="black"/>
                    <span class="checkmark"></span>
                </label>
                <label for="whites">
                    Whites
                    <input type="checkbox" id="whites"/>
                    <span class="checkmark"></span>
                </label>
                <label for="reds">
                    Reds
                    <input type="checkbox" id="reds"/>
                    <span class="checkmark"></span>
                </label>
                <label for="greys">
                    Greys
                    <input type="checkbox" id="greys"/>
                    <span class="checkmark"></span>
                </label>
                <label for="blues">
                    Blues
                    <input type="checkbox" id="blues"/>
                    <span class="checkmark"></span>
                </label>
                <label for="beige">
                    Beige Tones
                    <input type="checkbox" id="beige"/>
                    <span class="checkmark"></span>
                </label>
                <label for="greens">
                    Greens
                    <input type="checkbox" id="greens"/>
                    <span class="checkmark"></span>
                </label>
                <label for="yellows">
                    Yellows
                    <input type="checkbox" id="yellows"/>
                    <span class="checkmark"></span>
                </label>
            </div>
        </div>
    </div>
  )
}

export default Size
