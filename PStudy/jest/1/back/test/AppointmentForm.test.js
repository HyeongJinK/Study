import React from 'react';
import { createContainer } from './domManipulators';
import { AppointmentForm } from '../src/AppointmentForm';

describe('AppointmentForm', () => {
    let render, container;

    beforeEach(() => {
        ({ render, container } = createContainer());
    });

    const form = id =>
        container.querySelector(`form[id="${id}"]`);

    it('renders a form', () => {
        render(<AppointmentForm />);
        expect(form('appointment')).not.toBeNull();
    });

    const field = name => form('appointment').elements[name];

    describe('service field', () => {
        const findOption = (dropdownNode, textContent) => {
            const options = Array.from(dropdownNode.childNodes);
            return options.find(
              option => option.textContent === textContent
            );
        };


        it('renders as a select box', () => {
            render(<AppointmentForm />);
            expect(field('service')).not.toBeNull();
            expect(field('service').tagName).toEqual('SELECT');
        });

        it('초기 선택된 값이 비어 있는 지 확인', () => {
            render(<AppointmentForm />);
            const firstNode = field('service').childNodes[0];
            expect(firstNode.value).toEqual('');
            expect(firstNode.selected).toBeTruthy();
          });

        it('lists all salon services', () => {
            const selectableServices = ['Cut', 'Blow-dry'];
            
            render(
                <AppointmentForm
                    selectableServices={selectableServices}
                />
            );
            
            const optionNodes = Array.from(     //서비스 필드의 자식노드 가져오기
                field('service').childNodes
            );
            const renderedServices = optionNodes.map(   //노드에 텍스트 가져오기
                node => node.textContent
            );
            expect(renderedServices).toEqual(
                expect.arrayContaining(selectableServices)  //해당 select에 배열에 있는 값이 존재하는 지
            );
        });

        it('pre-selects the existing value', () => {
            const services = ['Cut', 'Blow-dry'];
            render(
              <AppointmentForm
                selectableServices={services}
                service="Blow-dry"
              />
            );
            const option = findOption(
              field('service'),
              'Blow-dry'
            );
            expect(option.selected).toBeTruthy();
        });
    });
});