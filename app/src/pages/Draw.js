import React, { useState, createContext } from 'react';
import Downshift from 'downshift';
import styled, { css } from 'styled-components';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

import GlobalFonts from './fonts';
import Bg from '../image/background.png';
import Logo from '../image/logo.png';
import GoBtn from '../image/button/go.png';
import GoHoverBtn from '../image/button/go_hover.png';
import InputBox from '../image/box/inputbox_300x73.png';
import SelectBox from '../image/box/inputbox_300x202.png';
import InputBoxHover from '../image/box/inputbox_hover.png';
import InputBoxSelected from '../image/box/inputbox_selected.png';
import Triangle from '../image/button/triangle.png';
import SpinningCoin from '../image/icon/coin.gif';

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

const InputContainer = styled.div`
  margin-top: 300px;
`;

const Input = styled.div`
  background-image: url(${InputBox});
  width: 300px;
  height: 72.86px;
  border: none;

  input {
    border: none;
    font-family: 'DungGeunMo';
    font-size: 26px;
    width: 169px;
    margin: 20px 18px 26.86px 18px;
    border-radius: 0px;
    color: black;
    text-align: center;

    &::placeholder {
      font-family: 'DungGeunMo';
      font-size: 26px;
      color: black;
    }

    &:focus {
      outline: none;
    }
  }

  button {
    background-image: url(${Triangle});
    background-repeat: no-repeat;
    background-color: white;
    border: none;
    width: 22px;
    height: 22px;
    padding-bottom: 4px;
    cursor: pointer;

    &:focus {
      outline: none;
    }
  }
`;

const Select = styled.ul`
  background-image: url(${SelectBox});
  width: 300px;
  height: 202px;
  border: none;
  background-color: white;
  white-space: nowrap;
  overflow: auto;
  margin: 0px;
  padding-top: 13px;
`;

const Items = styled.li`
  ${({ selected }) => {
    if (selected) {
      return css`
        background-image: url(${InputBoxSelected});
        width: 300px;
        height: 58;
      `;
    }
  }};

  padding: 13px;
  font-family: 'DungGeunMo';
  font-size: 26px;
  border: none;

  &:hover {
    background-image: url(${InputBoxHover});
    background-repeat: no-repeat;
    width: 300px;
    height: 58px;
  }

  &::after {
    content: '';
    display: block;
    justify-content: center;
    width: 250px;
    margin: 3px auto;
  }
`;

const SpinningCoinIcon = styled.img.attrs({
  src: SpinningCoin,
})`
  margin: 0 15px -8px 0;
`;

const GoButton = styled.button`
  background-image: url(${GoBtn});
  border: none;
  width: 167px;
  height: 68.51px;
  background-color: white;
  margin-top: 107px;
  cursor: pointer;

  &:hover {
    background-image: url(${GoHoverBtn});
    width: 167px;
    height: 68.51px;
  }
`;

// const coins = ['코인 1개', '코인 3개', '코인 5개'];

const coins = [
  {
    label: '코인 1개',
    value: 1,
  },
  {
    label: '코인 3개',
    value: 3,
  },
  {
    label: '코인 5개',
    value: 5,
  },
];

function Draw() {
  const [selectedOption, setSelectedOption] = useState(null);
  const [data, setData] = useState(null);
  const navigate = useNavigate();

  const onSelect = (selection) => {
    const coinSelection = selection;
    return setSelectedOption(coinSelection.value);
  };

  const insertCoin = async () => {
    try {
      const getResponse = await axios.get('/draw/1', {
        params: { coinCount: selectedOption },
      });
      console.log(getResponse.data);
      setData(getResponse.data);
      navigate('/result', { state: { data: getResponse.data } });
    } catch (error) {
      console.error('Error fetching data: ', error);
    }
  };

  return (
    <Background>
      <Container>
        <GlobalFonts />
        <TitleContainer>
          <Title></Title>
        </TitleContainer>
        <InputContainer>
          <Downshift
            onChange={(selection) => onSelect(selection)}
            itemToString={(item) => (item ? item.label : '')}
          >
            {({
              getInputProps,
              getItemProps,
              getMenuProps,
              getToggleButtonProps,
              isOpen,
              selectedItem,
            }) => (
              <div>
                <Input>
                  <input
                    readOnly={true}
                    placeholder="코인을 넣자 !"
                    {...getInputProps()}
                  />
                  <button {...getToggleButtonProps()}></button>
                </Input>
                {isOpen ? (
                  <Select {...getMenuProps()}>
                    {coins.map((item, index) => (
                      <Items
                        selected={selectedItem === item}
                        {...getItemProps({
                          key: item.value,
                          index,
                          item,
                        })}
                      >
                        <SpinningCoinIcon></SpinningCoinIcon>
                        {item.label}
                      </Items>
                    ))}
                  </Select>
                ) : null}

                <GoButton
                  onClick={insertCoin}
                  {...(isOpen
                    ? { style: { display: 'none' } }
                    : { style: { visibility: 'visible' } })}
                ></GoButton>
              </div>
            )}
          </Downshift>
        </InputContainer>
      </Container>
    </Background>
  );
}

export default Draw;
