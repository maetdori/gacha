import { createGlobalStyle } from 'styled-components';
import ArcadeClassic from '../fonts/ARCADECLASSIC.TTF';
import DungGeunMo from '../fonts/DungGeunMo.ttf';

export default createGlobalStyle`
    @font-face {
        font-family: "ArcadeClassic";
        src: local("ArcadeClassic"),
        url(${ArcadeClassic}) format('truetype');
    }
    @font-face {
        font-family: "DungGeunMo";
        src: local("DungGeunMo"),
        url(${DungGeunMo}) format('truetype');
    }
`;
