import React from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';

import Bg from '../image/background.png';
import Logo from '../image/logo.png';
import StartBtn from '../image/button/start.png';
import StartHoverBtn from '../image/button/start_hover.png';

const Background = styled.div`
  background-image: url(${Bg});
  width: 100%;
  height: 100%;
  background-size: 100% 100%;
  background-position: center;
  background-repeat: no-repeat;
  position: fixed;
`;

const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100%;
`;

const TitleContainer = styled.div`
  position: absolute;
  left: 50%;
  margin-top: 110px;
  transform: translateX(-50%);
`;

const Title = styled.div`
  background-image: url(${Logo});
  width: 300px;
  height: 56px;
  margin-bottom: 30px; /* 타이틀 사이의 간격 줄임 */
`;

const ButtonContainer = styled.div`
  position: absolute;
  margin-top: 480px; /* 버튼과 타이틀 사이의 간격 추가 */
`;

const StartButton = styled.button`
  background-image: url(${StartBtn});
  background-color: transparent; /* 배경색 제거 */
  border: none;
  width: 167px;
  height: 69px; /* 버튼 높이 조정 */
  cursor: pointer;

  &:hover {
    background-image: url(${StartHoverBtn});
  }
`;

// 메인 컴포넌트 정의

const Main = () => {
  return (
    <Background>
      <Container>
        <TitleContainer>
          <Title />
          <Title />
          <Title />
        </TitleContainer>
        <ButtonContainer>
          <Link to="/draw">
            <StartButton />
          </Link>
        </ButtonContainer>
      </Container>
    </Background>
  );
};

export default Main;
