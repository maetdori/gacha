import styled from 'styled-components';
import { useLocation } from 'react-router-dom';
import { Link } from 'react-router-dom';

import GlobalFonts from './fonts';
import Bg from '../image/background.png';
import Logo from '../image/logo.png';
import ResultBox from '../image/box/notice_300x300.png';
import StarIcon from '../image/star.png';
import RestartBtn from '../image/button/restart.png';
import RestartHoverBtn from '../image/button/restart_hover.png';

const Background = styled.div`
  background-image: url(${Bg});
  width: 100%;
  height: 100%;
  background-size: 100% 100%;
  background-position: center;
  background-repeat: no-repeat;
  text-align: center;
  position: fixed;
`;

const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
  height: 100%;
`;

const TitleContainer = styled.div`
  position: absolute;
  left: 50%;
  margin-top: 110px;
  transform: translateX(-50%); /* 수평 가운데 정렬 유지 */
`;

const Title = styled.div`
  background-image: url(${Logo});
  width: 300px;
  height: 56px;
  margin-bottom: 40px;
`;

const ResultContainer = styled.div`
  background-image: url(${ResultBox});
  width: 300px;
  height: 300px;
  margin-top: 200px;
  display: flex;
  flex-direction: column; /* 컨테이너 안의 요소들을 세로로 배열 */
  align-items: center; /* 가로 중앙 정렬 */
`;

const StarContainer = styled.div`
  width: 146px;
  height: 30px;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 10px;
`;

const Star = styled.div`
  background-image: url(${StarIcon});
  width: 30px;
  height: 30px;
  background-repeat: no-repeat;
`;

const ItemContainer = styled.div`
  text-align: center;
  margin-top: 17px;
  display: flex;
  flex-direction: column;
  align-items: center;
  & > * {
    margin-bottom: 20px; /* 각 요소 사이의 간격을 조절할 수 있습니다. */
  }
`;

const Text = styled.div`
  border: none;
  font-family: 'DungGeunMo';
  font-size: 22px;
  color: black;
`;

// Image 스타일 정의
const Image = styled.img`
  width: 100px;
  height: 100px;
`;

const ButtonContainer = styled.div`
  position: absolute;
  margin-top: 530px; /* 버튼과 타이틀 사이의 간격 추가 */
`;

const RestartButton = styled.button`
  background-image: url(${RestartBtn});
  background-color: transparent; /* 배경색 제거 */
  border: none;
  width: 167px;
  height: 69px; /* 버튼 높이 조정 */
  cursor: pointer;

  &:hover {
    background-image: url(${RestartHoverBtn});
  }
`;

function Result() {
  const location = useLocation();
  const data = location.state?.data;
  const starCount = data?.star || 0;
  const itemName = data?.name || '';
  const imgUrl = data?.imgUrl || '';

  return (
    <Background>
      <Container>
        <GlobalFonts />
        <TitleContainer>
          <Title></Title>
        </TitleContainer>
        <ResultContainer>
          <StarContainer>
            {Array.from({ length: starCount }, (_, index) => (
              <Star key={index} />
            ))}
          </StarContainer>
          <ItemContainer>
            {itemName && <Text>『{itemName}』</Text>}
            {imgUrl && <Image src={imgUrl} alt="Item Image" />}
            <Text>를 획득했다 -!!</Text>
          </ItemContainer>
        </ResultContainer>
        <ButtonContainer>
          <Link to="/draw">
            <RestartButton />
          </Link>
        </ButtonContainer>
      </Container>
    </Background>
  );
}

export default Result;
